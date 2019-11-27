package org.singleton.summary.algorithm;

/**
 * @author singleton_zw
 * @title: BallRebound
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/10/29 16:24
 *
 *
 * 一个球从100m高度自由落下，每次落地后反弹回原来高度的一半，再落下。求它在第10次落地并反弹到最高点，共经过多少m？第10次反弹多高？
 *
 */
public class BallRebound {

    public static void main(String[] args) {
        getHigth();
        geth();
        double hight = 100;
        for (int i = 0; i < 10; i++) {
            hight = hight/2;
            System.out.println(hight);
        }
    }

    /**
     * 一个球从100m高度自由落下，每次落地后反弹回原来高度的一半，再落下。求它在第10次落地并反弹到最高点，共经过多少m？第10次反弹多高？
     */
    public static void getHigth(){
        float l = 100f;
        float s = l;    //第一次落地
        for (int i = 0; i < 9; i++) {
            l /= 2;
            if (i == 10) {//最后一次只弹起不落地
                s += l;
            } else {
                s += 2 * l;
            }
        }
        System.out.println("经过" + s + "米,最后一次高" + l + "米");
    }


    /**
     * 复杂版
     *  一个球从100m高度自由落下，每次落地后反弹回原来高度的一半，再落下。求它在第10次落地并反弹到最高点，共经过多少m？第10次反弹多高？
     * @methodsDescription:代码量复杂
     * @methodName: geth
     * @author: singleton-zw
     * @return: void
     */
    public static void geth(){
        float h = 100f;
        float s = h;
        float higth = 0f;
        //第一次只有下没有上
        for(int i =1;i<10;i++){
            //反弹后的高度
            higth = getReturnHigth(h);
            System.out.println("第"+(i+1)+"弹起的距离--"+higth);
            //再去求反弹的路径
            h = higth;
            //要注意的是第二次的距离是下去加反弹的距离 （注意的是原来一半的距离）
            s += (higth*2);
            System.out.println("第"+(i+1)+"整次过程----"+s);
        }
        System.out.println("所有:"+s +"   最后一次"+higth);

    }

    /**
     *
     * @methodsDescription:算出反弹数
     * @methodName: getReturnHigth
     * @param s
     * @return
     * @author: singleton-zw
     * @return: float
     */
    public static float getReturnHigth(float s){
        return s/2;
    }

}
