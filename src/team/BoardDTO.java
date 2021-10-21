package team;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	private int boardNm;
	private String boardTitle;
	private String boardSub;
	private int userNm;
	private Date boardDate;
	private int boardCount;

}
