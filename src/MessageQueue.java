public class MessageQueue {
    boolean inUse = false;
    int size = 0;
    MessageFragment head = null;
    MessageFragment tail = null;
    String sendReceive;//names of sender and recipient

    public void clear(){
        size = 0;
        head = null;
        tail = null;
        inUse = false;
    }

    public String getStatus(int num){
        if (inUse) return "Queue #"+ num
                +": Unavailable.\n" + size
                + " characters remaining.";
        else return "Queue #"+ num
                +": Available";
    }

    public MessageFragment poll(){
        MessageFragment currHead = null;
        if (size == 0){
            System.out.println("Queue is empty");
        }else{
            currHead = head;
            head = head.nextFragment;
            --size;
        }
        return currHead;
    }
    public void enqueue(String message, String _sendReceive)throws IllegalStateException{
        if (inUse) throw new IllegalStateException("Queue in use."
                +size + " characters remaining.");
        if (message.length() == 0){
            System.out.println("Received an empty string. Nothing added to queue.");
            return;
        }
        inUse = true;
        sendReceive = _sendReceive;
        char[] c_message = message.toCharArray();
        for (char c: c_message) {
            if (size == 0){
                head = new MessageFragment(c,null);
                tail = head;
            }else{
                tail.nextFragment = new MessageFragment(c,null);
                tail = tail.nextFragment;
            }
            ++size;
        }

    }



}
