class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoInt = StringToInt(video_len);
        int startInt = StringToInt(op_start);
        int endInt = StringToInt(op_end);
        int posInt = StringToInt(pos) >= startInt && StringToInt(pos) <= endInt ? endInt : StringToInt(pos);
        for(String command : commands){
            if(command.equals("next")){
                posInt = posInt+10 > videoInt ? videoInt : posInt+10;
                posInt = posInt >= startInt && posInt <= endInt ? endInt : posInt;
            } else if(command.equals("prev")){
                posInt = posInt-10 < 0 ? 0 : posInt-10;
                posInt = posInt >= startInt && posInt <= endInt ? endInt : posInt;
            }
        }
        
        int m = posInt/60;
        int s = posInt%60;
        String mString;
        String sString;
        if(m < 10){
            mString = "0" + m;
        }else{
            mString = "" + m;
        }
        
        
        if(s < 10){
            sString = "0" + s;
        }else{
            sString = "" + s;
        }
    
        return mString + ":" + sString;
    }
    
    public static int StringToInt(String time){
        String[] video_len_String = time.split(":");
        int[] video_len_Int = new int[2];
        video_len_Int[0] = Integer.parseInt(video_len_String[0]);
        video_len_Int[1] = Integer.parseInt(video_len_String[1]);
        
        return video_len_Int[0] * 60 + video_len_Int[1]; 
    }
}