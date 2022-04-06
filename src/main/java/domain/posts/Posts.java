package domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//여기서 잠깐! 정리
//getter : 외부로 값 반환
//setter : 외부러부터 값을 받아옴


//Entity클래스에는 절대 Setter메소드를 만들지 않는다.
//그 이유는 차후 기능변경시 복잡하기 때문
//Setter가 없으므로 생성자를 통해 최종값을 통해 DB에 삽입함, 값 변경이 필요할 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경

//이 책에서는 생성자 대신 @Builder를 통해 제공되는 빌더클래스를 사용하는데 생성장나 빌더나 역할은 똑같지만 생성자의 경우 지금 채워야할 필드가 무엇인지 정확히 지정 불가
//앞으로 모든 예제는 빌더 패턴 적극적으로 사용
@Getter //롬복의 어노테이션, get메소드
@NoArgsConstructor  //롬복의 어노테이션, 파라미터가 없는 기본생성자 생성
@Entity //JPA의 어노테이션, 테이블과 링크될 클래스임을 나타낸다.
public class Posts {

    @Id //해당 테이블의 PK 필드를 나타낸다
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙을 나타낸다,GenerationType.IDENTITY옵션을 추가해야 auto된다.
    private Long id;

    @Column(length = 500,nullable = false)//테이블의 칼럼(속성과 같은말)을 나타냄
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder    //해당 클래스의 빌더 패턴 클래스 생성
    public Posts(String title,String content,String author){
        this.title = title;
        this.author = author;
        this.content = content;
    }
}

//Posts클래스 생성 완료 -> Posts클래스로 Database를 접근하게 해 줄 JpaRepository 생성