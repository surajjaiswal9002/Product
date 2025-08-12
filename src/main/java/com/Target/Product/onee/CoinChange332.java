package com.Target.Product.onee;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Arrays;

public class CoinChange332 {
    public static int combinationOfCoins(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i >= coin){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int ans = combinationOfCoins(coins, amount);
        System.out.println(" output : "+ans);
    }
}
