package org.scoula.cli;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MenuItem {
    private String title;
    private Command command;
}
