package definition;

public class MaintainCustomer {
    MyQueue<String> list = new MyQueue<>();

    public void addCustomer(String name) {
        list.add(name);
    }

    ;

    public void removeCustomer() {
        if (!list.isEmpty()) {
            list.remove();
        } else {
            System.out.println("SORRY!  NO CUSTOMER IS THERE TO BE REMOVED");
        }
    }

    public void displayCustomer() {
        if (!list.isEmpty()) {
            System.out.print("FIRST CUSTOMER IS : ");
            list.printFirst();
        } else {
            System.out.println("NO CUSTOMER IN THE QUEUE");
        }
    }

    public void size() {
        System.out.println(list.sizeOfList());
    }

}
