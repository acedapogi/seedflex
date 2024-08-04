package ace.example;



public class User implements Comparable<User>{
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public int getUserId(){
        return this.userId;
    }

    public int getId(){
        return this.id;
    }


    public String getTitle(){
        return this.title;
    }

    public boolean isCompleted(){
        return this.completed;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }

    public void setId(int id){
        this.id = id;
    }


    public void setTitle(String title){
        this.title = title;
    }

    public int compareTo(User user){

        return this.id - user.id;

        //return Comparator.comparing(User::getId)
        //  .thenComparing(User::getCompleted)
        //  .compare(this, user);
    }

    @java.lang.Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
