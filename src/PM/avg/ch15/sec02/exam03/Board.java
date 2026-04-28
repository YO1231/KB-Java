package PM.avg.ch15.sec02.exam03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Board {
    private String subject;
    private String content;
    private String writer;
}
