package pxu.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PhieuThuePhong")
public class PhieuThuePhong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_thue")
	private int id_thue;

	@Column(name = "name")
	private String name;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

	public int getId_thue() {
		return id_thue;
	}

	public void setId_thue(int id_thue) {
		this.id_thue = id_thue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PhieuThuePhong(int id_thue, String name, String status, Room room) {
		super();
		this.id_thue = id_thue;
		this.name = name;
		this.status = status;
		this.room = room;
	}

	public PhieuThuePhong() {
		super();
	}

	

}
