package com.gemini.ifelse.command;

/**
 * @author xiaocuizi
 * {@link https://www.toutiao.com/i6720738824827175436/?tt_from=weixin&utm_campaign=client_share&wxshare_count=1&timestamp=1568693948&app=news_article&utm_source=weixin&utm_medium=toutiao_ios&req_id=20190917121907010014047025100B4B44&group_id=6720738824827175436}
 */
public class AddCommand implements Command {
    private int a;
    private int b;

    public AddCommand(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer execute() {
        return a + b;
    }

    public static void main(String[] args) {
        do {
            System.out.println("cccccccccccc");
        }while (true);
    }
}