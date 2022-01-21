package librarymanagement;


abstract class Shelf {
    protected String shelfCode;
    protected String position;
    
    public Shelf(){
        shelfCode = "";
        position = "";
    }
    
    public void setSC(String shelfCode){
        this.shelfCode = shelfCode;
    }
    
    public void setPosition(String position){
        this.position = position;
    }
    
    public String getSC(){
        return shelfCode;
    }
    
    public String getPosition(){
        return position;
    }
    //protected abstract String getTitle();
    protected abstract void Borrow(int quantity);
    protected abstract void Return(int quantity);
}
