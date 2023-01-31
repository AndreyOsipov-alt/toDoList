
public class Tasks {
   private String status;
   private  String name;


   public Tasks(String name){
       this.name=name;
       this.status="[ ]";
   }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
