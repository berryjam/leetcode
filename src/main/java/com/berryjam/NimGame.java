package com.berryjam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjinkun.
 * @date 16/2/25
 * @time 下午11:59
 */
public class NimGame {

    public boolean canWinNim(int n) {
//        boolean[] arrays = {true,true,true,false};
//        if(n<=4){
//            return arrays[n-1];
//        }else{
//            for(int i=5;i<=n;i++){
//                boolean result = !arrays[3]||!arrays[2]||!arrays[1];
//                arrays[0]=arrays[1];
//                arrays[1]=arrays[2];
//                arrays[2]=arrays[3];
//                arrays[3]=result;
//            }
//            return arrays[3];
//        }

        if(n%4==0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NimGame game = new NimGame();
        for(int i=1;i<=15;i++){
            System.out.println(i+":"+game.canWinNim(i));
        }
    }
}
