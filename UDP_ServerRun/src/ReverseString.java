public class ReverseString {
    private String str;
    public ReverseString() { }
    public ReverseString(String str) {
        this.str = str; }
    public void reverse(){
        String tmp ="";
        for(int i=str.length() - 1; i >=0 ;i--)
            tmp += str.substring(i, i+1);
        this.str = tmp;
    }
    public String getStr() {
        return str;
    }
    public void setStr(String str) {
        this.str = str;
    }
}
