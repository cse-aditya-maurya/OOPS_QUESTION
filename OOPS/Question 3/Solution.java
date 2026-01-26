public class Solution{
    public static void main(String[] args) {
        Elevator e = new Elevator(9);
        e.moveUp();
        e.moveUp();
        e.moveDown();
        e.display();
    }
}

class Elevator {
    private int floor;

    Elevator(int floor) {
        this.floor = floor;
    }

    public void moveUp() {
        if (floor < 10) {
            floor++;
        } else {
            System.out.println("Already at top floor");
        }
    }

    public void moveDown() {
        if (floor > 1) {
            floor--;
        }
    }

    public void display() {
        System.out.println("Current Floor: " + floor);
    }
}