package com.ibam.projetvagrant.dto;

import lombok.*;

/**
 * @author S. Lamoussa OUATTARA
 * @date 17/07/2024
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseDTO<T> {
    private String code;
    private String msg;
    private T data;
}
