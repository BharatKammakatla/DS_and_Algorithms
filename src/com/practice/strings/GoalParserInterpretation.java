package com.practice.strings;

public class GoalParserInterpretation {
    public static void main(String[] args) {

        GoalParserInterpretation gpi = new GoalParserInterpretation();
        String command = "G()(al)";
        System.out.println(gpi.interpret(command));

    }

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder(command.length());
        int i = 0;
        while(i<command.length()){
            if(command.charAt(i) == 'G'){
                sb.append('G');
                i++;
            }else if(command.charAt(i) == '('){
                if(command.charAt(i+1) == ')'){
                    sb.append('o');
                    i+=2;
                }else{
                    sb.append("al");
                    i+=4;
                }
            }
        }
        return sb.toString();
    }

}
