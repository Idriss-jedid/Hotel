package model;

public class HotelRoom {
    private String hotelName;
    private int numberOfStars;
    private String city;
    private String roomType;
    private double price;
    private int capacity;
    private String imageUrl;

    public HotelRoom() {}
    public HotelRoom(String hotelName, int numberOfStars, String city, String roomType,
                    double price, int capacity, String imageUrl) {
        this.hotelName = hotelName;
        this.numberOfStars = numberOfStars;
        this.city = city;
        this.roomType = roomType;
        this.price = price;
        this.capacity = capacity;
        this.imageUrl = imageUrl;
    }

    // Getters
    public String getHotelName() {
        return hotelName;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public String getCity() {
        return city;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getImageUrl() {
        return imageUrl;
    }
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public void setNumberOfStars(int numberOfStars) {
		this.numberOfStars = numberOfStars;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
    
}
