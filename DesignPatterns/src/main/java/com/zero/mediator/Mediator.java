package com.zero.mediator;

/**
 * @ClassName Mediator
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 20:50
 * @Version 1.0
 */
public class Mediator {

    /**
     *             调停者/中介者模式  （Mediator）
     *
     *  调停者模式解决多个对象间互相引用，相互出现大量的耦合的场景，
     *
     *  通过引入中间的调停者，将所有的调用方进行解耦合
     *
     *
     * 可以将各个类间的相互耦合调整为每一个对象与调停者之间的耦合，
     *
     * 调用者只需要向调停者发起请求或者响应调停者的调用即可，减轻了维护工作量
     *
     *
     *  ==================================
     *
     *  调停者可以解除不必要的业务耦合，保证服务的简单化，模块化，但是同时，对调停者的吞吐及响应能力提出了要求
     * 因此，具体的运用需要仔细思考具体的业务场景，灵活使用
     * 现在微服务中运用的消息中间件，各种MQ，不就是在扮演一个调停者的角色么~
     *
     *
     *
     *
     *
     *
     */
}