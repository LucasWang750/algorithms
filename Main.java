package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        String abc = " abcdefghijklmnopqrstuvwxyz";

        String message = "we found a treasure";
        int num = 0;
        String message2 = "";
        for(int i = 0; i < message.length(); i++){
            for(int j = 0; j < abc.length()-1; j++){
                if(message.substring(i,i+1).equals(" ")){
                    num = 27;
                    break;
                }
                if(abc.substring(j, j+1).equals(message.substring(i,i+1)))
                {
                    num = j;
                    break;
                }
            }
            message2 += abc.substring(27-num, 28-num);
        }
        System.out.println(message2 + "!");
    }
}
