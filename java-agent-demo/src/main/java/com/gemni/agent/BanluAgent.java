package com.gemni.agent;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/10 11:15
 */
public class BanluAgent {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("preman=" + args);
        instrumentation.addTransformer(new ClassFileTransformer() {
            /**
             *
             * @param loader  当前类的加载器
             * @param className 当前正在装载的类
             * @param classBeingRedefined 二次装载
             * @param protectionDomain 类的域
             * @param classfileBuffer 该类文件的字节码
             * @return
             * @throws IllegalClassFormatException
             */
            @Override
            public byte[] transform(ClassLoader loader,
                                    String className,
                                    Class<?> classBeingRedefined,
                                    ProtectionDomain protectionDomain,
                                    byte[] classfileBuffer) throws IllegalClassFormatException {

                if (loader == null || className == null) {
                    return null;
                }

                if (!className.equals("com/gemini/SayHelloService")) {
                    return null;
                }
                // javassist
                ClassPool classPool = new ClassPool();
                try {
                    classPool.insertClassPath(new LoaderClassPath(loader));
                    // classPool.insertClassPath(new ByteArrayClassPath(className,classfileBuffer));
                    if(className.contains("/")){
                        className = className.replaceAll("/",".");
                    }
                    CtClass ctClass = classPool.get(className);
                    CtMethod sayHello = ctClass.getDeclaredMethod("sayHello");
                    sayHello.insertBefore("  System.out.println(System.currentTimeMillis());");
                    return ctClass.toBytecode();
                } catch (NotFoundException e) {
                    e.printStackTrace();
                } catch (CannotCompileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return classfileBuffer;
            }
        });


    }
}


