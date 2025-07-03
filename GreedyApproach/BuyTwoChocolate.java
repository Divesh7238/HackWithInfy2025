import java.util.*;

public class BuyTwoChocolate {
     public static void main(String[] args) {
        
    
    Scanner sc =  new Scanner(System.in);

    int n = sc.nextInt();
    int[] prices = new int[n];
    for(int i =0; i<n; i++){
        prices[i] = sc.nextInt();

    }
    int money = sc.nextInt();

    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;

    for( int price : prices ){
        if(price < min1){
            min1 = min2;
            min1 = price;

        }else{
            min2 = price;
        }
    }

    int totalcast = min1 + min2;
    
    if(totalcast <= money){
        System.out.println(money - totalcast);
    }else{
        System.out.println(money);
    }
    
}
}