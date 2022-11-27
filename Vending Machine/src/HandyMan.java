public class HandyMan extends VendingMachine{
    private String name;
    private String passcode = "1234";
    public HandyMan(String name) {
        this.name = name;
    }
    public  boolean checkIfHandyMan(String password){
        return passcode.equals(password);
    }

}
