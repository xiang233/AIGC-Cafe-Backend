package com.aigccafe.buterin.common.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ModelType {
    CHECKPOINT("Checkpoint"),
    LORA("LORA"),
    TextualInversion("TextualInversion"),
    HyperNetwork("Hypernetwork"),
    AestheticGradient("AestheticGradient"),
    LyCORIS("LoCon"),
    ControlNet("Controlnet"),
    Upscaler("Upscaler"),
    VAE("VAE"),
    Poses("Poses"),
    Wildcards("Wildcards");
    private final String value;
}
