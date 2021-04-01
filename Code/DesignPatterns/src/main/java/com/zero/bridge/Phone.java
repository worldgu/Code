package com.zero.bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 手机定义
 * @ClassName Phone
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 16:42
 * @Version 1.0
 */
public abstract  class Phone {

    private List<Game> games = new ArrayList<>();

    protected abstract String getName ();

    public void installGame (Game game) {
        System.out.println("正在安装 " + game.getName());
        games.add(game);
    }

}
