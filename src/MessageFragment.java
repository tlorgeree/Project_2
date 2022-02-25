public class MessageFragment {
    char letter;
    MessageFragment nextFragment;

    public MessageFragment(char _letter, MessageFragment _nextFragment){
        nextFragment = _nextFragment;
        letter = _letter;
    }
}
