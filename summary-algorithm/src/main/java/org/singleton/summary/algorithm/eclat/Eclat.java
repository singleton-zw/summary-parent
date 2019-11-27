package org.singleton.summary.algorithm.eclat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import mpi.MPI;

public class Eclat {

    public String SPLIT;
    public int minSuport;
    public ArrayList<Set<String>> subsets = new ArrayList<Set<String>>();

    public List<String> transList = new ArrayList<String>();
    public List<String> transListSub1 = new ArrayList<String>();
    public List<String> transListSub2 = new ArrayList<String>();
    private Map<String, Set<String>> datas;

    public Eclat(String fileSrcRead, String SPLIT, int minSuport) {

        this.minSuport = minSuport;
        this.SPLIT = SPLIT;
        this.transList.addAll(readData2Project(fileSrcRead));
//		System.out.println(this.transList);
        int flag = this.transList.size() / 2;
        for (int i = 0; i < this.transList.size(); i++) {
            if (i <= flag) {
                transListSub1.add(transList.get(i));
            } else {
                transListSub2.add(transList.get(i));
            }
        }

    }


    public Map<String, Set<String>> getDatas() {
        return datas;
    }

    public void setDatas(Map<String, Set<String>> datas) {
        this.datas = datas;
    }

    public void getTidResultFirst_C(String fileSrc) {
//		System.out.println(fileSrc);
        datas = new HashMap<String, Set<String>>();
        for (String string : transList) {
            String[] records = string.split(SPLIT);
            for (int i = 0; i < records.length; i++) {
                if (!datas.containsKey(records[i])) {
                    datas.put(records[i], new HashSet<String>());
                }
                datas.get(records[i]).add(records[0]);
            }
        }
        Set<String> dataString = datas.keySet();
        Iterator<String> it = dataString.iterator();
        while (it.hasNext()) {
            String key = it.next();
            writeResult2File("项集" + key + "的支持度为:[" + datas.get(key).size() + "]\n",
                    fileSrc);

        }

    }

    public void getTidResultFirst_B(String fileSrc, List<String> transList) {
        datas = new HashMap<String, Set<String>>();
        for (String string : transList) {
            String[] records = string.split(SPLIT);
            for (int i = 1; i < records.length; i++) {
                if (!datas.containsKey(records[i])) {
                    datas.put(records[i], new HashSet<String>());
                }
                datas.get(records[i]).add(records[0]);
            }
        }
        Set<String> dataString = datas.keySet();
        Iterator<String> it = dataString.iterator();
        while (it.hasNext()) {
            String key = it.next();
            writeResult2File("项集" + key + "的支持度为:[" + datas.get(key).size() + "]\n",
                    fileSrc);

        }

    }

    public ArrayList<TidResult> getTidResult(ArrayList<Set<String>> subsetOld) {

        Set<String> keys = datas.keySet();

        subsets = getSubset(subsetOld, keys);

        Set<String> tmp = new HashSet<String>();
        ArrayList<TidResult> fItems = new ArrayList<TidResult>();
        for (Set<String> set : subsets) {
            tmp.clear();
            Iterator<String> it = set.iterator();
            if (it.hasNext()) {
                tmp.addAll(datas.get(it.next()));
                while (it.hasNext() && tmp.size() >= minSuport) {
                    tmp.retainAll(datas.get(it.next()));
                }
            }
            if (tmp.size() >= minSuport) {
                fItems.add(new TidResult(set.toString(), tmp.size()));
            }
        }
        return fItems;
    }

    public ArrayList<Set<String>> getSubset(ArrayList<Set<String>> subsetOld, Set<String> items) {
        ArrayList<Set<String>> subsetsNew = new ArrayList<Set<String>>();
        for (int i = 0; i < subsetOld.size(); i++) {
            Set<String> temp = new HashSet<String>();
            temp.addAll(subsetOld.get(i));
            Iterator<String> it_items = items.iterator();
            while (it_items.hasNext()) {
                String temp_String = it_items.next();
                if (!temp.contains(temp_String)) {
                    temp.add(temp_String);

                    if (!subsetsNew.contains(temp)) {
                        subsetsNew.add(temp);
                    }
                    temp = new HashSet<String>();
                    temp.addAll(subsetOld.get(i));
                }

            }
        }

        return subsetsNew;
    }

    public List<String> readData2Project(String fileSrc) {
        List<String> transList = new ArrayList<String>();
        try {
            FileInputStream fis = new FileInputStream(new File(fileSrc));

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String str = null;
            while ((str = br.readLine()) != null) {
                transList.add(str);
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return transList;

    }

    public void writeResult2File(String content, String src) {
        FileWriter fw = null;
        try {

            File f = new File(src);
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mainFlow_C(String fileSrc) {
        getTidResultFirst_C(fileSrc);
        boolean flag = true;
        ArrayList<Set<String>> subset = new ArrayList<Set<String>>();
        Iterator<String> temp = getDatas().keySet().iterator();
        while (temp.hasNext()) {
            Set<String> temp_Set = new HashSet<String>();
            temp_Set.add(temp.next());
            subset.add(temp_Set);

        }
        while (flag) {
            ArrayList<TidResult> fItems = getTidResult(subset);
            subset = subsets;
            Set<Boolean> flagList = new HashSet<Boolean>();
            if (fItems.size() != 0) {

                for (int i = 0; i < fItems.size(); i++) {
                    if (fItems.get(i).getValue() == 0) {
                        flag = flag || false;
                    } else {
                        flag = flag || true;
                    }
//					System.out.println("项集" + fItems.get(i).getKey() + "的支持度为:[" + fItems.get(i).getValue() + "]");
                    writeResult2File("项集" + fItems.get(i).getKey() + "的支持度为:[" + fItems.get(i).getValue() + "]\n",
                            fileSrc);
                }
            } else {
                return;
            }
        }
    }
//	public void mainFlow_B(String fileSrc) {
//		int me = MPI.COMM_WORLD.Rank();
//		int size = MPI.COMM_WORLD.Size();
//		int flag1 = 1;
//		if (me == 0) {
//			getTidResultFirst_B(fileSrc,transListSub1);
//			MPI.COMM_WORLD.Recv((Object)flag1,0,1,MPI.INT,1,0);}
//		else{
//			getTidResultFirst_B(fileSrc,transListSub2);
//			MPI.COMM_WORLD.Send((Object)flag1,0,1,MPI.INT,0,0);
//		}
//		boolean flag = true;
//		ArrayList<Set<String>> subset = new ArrayList<Set<String>>();
//		Iterator<String> temp = getDatas().keySet().iterator();
//		while (temp.hasNext()) {
//			Set<String> temp_Set = new HashSet<String>();
//			temp_Set.add(temp.next());
//			subset.add(temp_Set);
//
//		}
//		while (flag) {
//			ArrayList<TidResult> fItems = getTidResult(subset);
//			subset = subsets;
//			Set<Boolean> flagList = new HashSet<Boolean>();
//			if (fItems.size() != 0) {
//
//				for (int i = 0; i < fItems.size(); i++) {
//					if (fItems.get(i).getValue() == 0) {
//						flag = flag || false;
//					} else {
//						flag = flag || true;
//					}
////					System.out.println("项集" + fItems.get(i).getKey() + "的支持度为:[" + fItems.get(i).getValue() + "]");
//					writeResult2File("项集" + fItems.get(i).getKey() + "的支持度为:[" + fItems.get(i).getValue() + "]\n",
//							fileSrc);
//				}
//			} else {
//				return;
//			}
//		}
//	}
}
