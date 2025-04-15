package com.aigccafe.buterin.common.model.journey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageInfo {

    private String imageUrl;

    private String rawImageUrl;
}
