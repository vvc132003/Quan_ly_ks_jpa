package pxu.com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "room_name")
	private String room_name;

	@Column(name = "price")
	private float price;

	@Column(name = "status")
	private String status;

	@OneToMany(mappedBy = "room")
	private List<PhieuThuePhong> phieuThuePhongs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Room(int id, String room_name, float price, String status, List<PhieuThuePhong> phieuThuePhongs) {
		super();
		this.id = id;
		this.room_name = room_name;
		this.price = price;
		this.status = status;
		this.phieuThuePhongs = phieuThuePhongs;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PhieuThuePhong> getPhieuThuePhongs() {
		return phieuThuePhongs;
	}

	public void setPhieuThuePhongs(List<PhieuThuePhong> phieuThuePhongs) {
		this.phieuThuePhongs = phieuThuePhongs;
	}

	public Room() {
		super();
	}

}
