package sda;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // identity  - pobiera id, nastepnie przypisuje wartosc do obiektu i zapisuje obiekt
    // sequence - zapisuje obiekt, pobiera go z powrotem o sprawdza id
    private Long id;
    @Column(name = "name")
    private String imie;
    @Column (name = "surname")
    private String nazwisko;
    @Column (name = "indeksik")
    private String indeks;

}
