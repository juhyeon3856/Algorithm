class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean isCheck;
        for(int i=0; i<dic.length; i++){
            isCheck = true;
            for(int j=0; j<spell.length; j++){
                isCheck = isCheck && dic[i].contains(spell[j]);
            }
            if(isCheck) return 1;
        }
        return 2;
    }
}