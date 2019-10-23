package test;

public class staticClass {
    private String name;

    static {
        System.out.println("静态方法块。");
    }

    public void simplefunction(){
        System.out.println("简单方法，我是");
    }
}

