public class Main {
    public static void main(String[] args) {
        MessageSystem system = new MessageSystem();
        system.run();
        system.findFile();
        System.out.println(system.people);
    }
}