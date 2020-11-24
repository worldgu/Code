package com.zero.builder;

import lombok.Data;
import lombok.ToString;

/**
 *
 * 电脑创造者， 人为指定配置出的电脑用的什么CPU
 *
 * @ClassName Compute
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 14:53
 * @Version 1.0
 */
@Data
@ToString
public class Compute {

    private String cpu;

    private String memory;

    private String display;

    private String keyBroad;

    public static class Builder {

        private Compute compute;

        public Builder () {
            compute = new Compute();
        }

        public Builder cpu (String cpu) {
            compute.cpu = cpu;
            return this;
        }

        public Builder memory (String memory) {
            compute.memory = memory;
            return this;
        }

        public Builder display (String display) {
            compute.display = display;
            return this;
        }

        public Builder keyBroad (String keyBroad) {
            compute.keyBroad = keyBroad;
            return this;
        }

        public Compute build () {

            return compute;

        }

    }
}
