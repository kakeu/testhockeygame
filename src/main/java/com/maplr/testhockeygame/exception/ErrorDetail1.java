
package com.maplr.testhockeygame.exception;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail1 {
    private Date date;
    private String message; 
    private String details;
    private List<String> errors = new ArrayList<>();   
}
