class Palindrome {
   public static void main(String[] args) {
       if (args.length == 0) {
           System.out.println("Please provide an input string.");
           return;
       }
       
        String input = String.join(" ", args).toLowerCase(); 
       String reverse = "";

       for (int i = input.length() - 1; i >= 0; i--) {
           reverse += input.charAt(i);
       }

       if (input.equals(reverse))
           System.out.println("It is a palindrome.");
       else
           System.out.println("Not a palindrome.");
   }
}

