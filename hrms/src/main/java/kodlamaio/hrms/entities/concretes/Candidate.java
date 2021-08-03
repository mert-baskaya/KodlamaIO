package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Candidates")
public class Candidate {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firsName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "national_identity_number")
	private String nationalIdentityNumber;
	
	@Column(name = "birth_year")
	private String birthYear;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	//veritabanina neden kaydediliyor? tablo belirtmedim
	private String passwordRepeat;
	
}
