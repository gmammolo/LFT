.class public Output 
.super java/lang/Object

.method public <init>()V
 aload_0
 invokenonvirtual java/lang/Object/<init>()V
 return
.end method

.method public static print(I)V
 .limit stack 2
 getstatic java/lang/System/out Ljava/io/PrintStream;
 iload_0 
 invokestatic java/lang/Integer/toString(I)Ljava/lang/String;
 invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
 return
.end method

.method public static read()I
 .limit stack 3
 new java/util/Scanner
 dup
 getstatic java/lang/System/in Ljava/io/InputStream;
 invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
 invokevirtual java/util/Scanner/next()Ljava/lang/String;
 invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I
 ireturn
.end method
.method public static run()V
 .limit stack 1024
 .limit locals 256
 ldc 3
 istore 0
 iload 0
 ldc 2
 iadd 
 istore 1
 iload 1
 iload 0
 if_icmpgt L0
 ldc 0
 goto L1
L0:
 ldc 1
L1:
 ifeq L2
 iload 1
 invokestatic Output/print(I)V
 ldc 0
 goto L3
L2:
 ldc 1
L3:
 ifeq L4
 iload 0
 invokestatic Output/print(I)V
 ldc 1
 istore 1
L4:
 iload 1
 invokestatic Output/print(I)V
 return
.end method

.method public static main([Ljava/lang/String;)V
 invokestatic Output/run()V
 return
.end method

