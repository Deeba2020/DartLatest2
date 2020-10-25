
//attributes
public class Message {
    //whenever we put things in a class, it means every object of that
    //class will have all those things
    Customer sender;
    boolean read;
    String content;

    //constructor
    Message(Customer sender, String content){
        this.sender = sender;
        this.read = false;
        this.content = content;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public boolean isRead() { //have we used isRead instead og getRead? is it possible?
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override  //Why override? since message has no inheritance and we do not change behaviour of supercalss?
    public String toString() {
        return "Message{" +
                "sender=" + sender.getId() + "-" + sender.getName() +  //getID and getName from customer class.
                ", content='" + content + '\'' +      //message content from Message class.
                '}';
    }
}
