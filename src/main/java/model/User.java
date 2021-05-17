package model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

        public User(String username, int score){
                this.username = username;
                this.score =score;
        }

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private int id;

        @Column(nullable=false)
        private String username;

        @Column(nullable=false)
        private int score;


}

