package Task_4;
//https://www.youtube.com/watch?v=UoM7SqWIrtA

public class Room {

    private int guestsNumber;
    private int roomNumber;

    public Room(int x) {

    }

    public int getGuestsNumber() {
        return guestsNumber;
    }

    public void setGuestsNumber(int guestsNumber) {
        this.guestsNumber = guestsNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room(int guestsNumber, int roomNumber) {
        this.guestsNumber = guestsNumber;
        this.roomNumber = roomNumber;
    }
}
