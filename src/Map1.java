import FunCode.*;

import java.util.Date;

public class Map1 {

    private int ifjump; //跳跃标识
    private long jumptime;  //跳跃停留时间
    private JSprite A0; //主角
    private JSprite Ajump;  //跳跃动作

    public Map1(){

        ifjump = 0;
        //初始化主角
        A0 = new JSprite("A0");
        Ajump = new JSprite("Ajump0");
    }

    //==============================================================================
    //
    // 每局开始前进行初始化，清空上一局相关数据
    public void	GameInit()
    {
    }

    //==============================================================================
    //
    // 每局游戏进行中
    public void	GameRun( float fDeltaTime )
    {
        if (ifjump == 1){
            if ((new Date().getTime() - jumptime) / 100 > 2){
                A0.SetSpriteLinearVelocityY(30);
            }
        }

        if (A0.GetSpritePositionX() > (float)-42.700 && A0.GetSpritePositionX() < (float)-7.641){
            A0.SetSpriteWorldLimit(EnumDefine.WORLD_LIMIT_BOUNCE,(float)-45.000,(float)-5.000,(float)50,(float)17.320);
        }
    }

    //==============================================================================
    //
    // 本局游戏结束
    public void	GameEnd()
    {
    }

    // dOnMouseMove：鼠标移动后将被调用的方法
    // 参数 fMouseX, fMouseY：为鼠标当前坐标
    //
    public void	OnMouseMove( float fMouseX, float fMouseY )
    {
    }

    // dOnMouseClick：鼠标按下后将被调用的方法
    // 参数 iMouseType：鼠标按键值，见 enum MouseTypes 定义
    // 参数 fMouseX, fMouseY：为鼠标当前坐标
    //
    public void	OnMouseClick( int iMouseType, float fMouseX, float fMouseY )
    {
    }

    // dOnMouseUp：鼠标弹起后将被调用的方法
    // 参数 iMouseType：鼠标按键值，见 enum MouseTypes 定义
    // 参数 fMouseX, fMouseY：为鼠标当前坐标
    //
    public void	OnMouseUp( int iMouseType, float fMouseX, float fMouseY )
    {
    }

    // dOnKeyDown：键盘被按下后将被调用的方法
    // 参数 iKey：被按下的键，值见 enum KeyCodes 宏定义
    // 参数 bAltPress, bShiftPress，bCtrlPress：键盘上的功能键Alt，Ctrl，Shift当前是否也处于按下状态
    //
    public void	OnKeyDown( int iKey, boolean bAltPress, boolean bShiftPress, boolean bCtrlPress )
    {
        //设置主角的翻转
        if (iKey == EnumDefine.KEY_A){
            A0.SetSpriteLinearVelocityX(-20);
            A0.SetSpriteFlipX(true);
            Ajump.SetSpriteFlipX(true);
            A0.SetSpriteLinearVelocityY(30);
        }

        if (iKey == EnumDefine.KEY_D){
            A0.SetSpriteLinearVelocityX(20);
            A0.SetSpriteFlipX(false);
            Ajump.SetSpriteFlipX(false);
            A0.SetSpriteLinearVelocityY(30);
        }

        if (iKey == EnumDefine.KEY_W){
            ifjump = 1;
            jumptime = new Date().getTime();
            Ajump.SetSpriteVisible(true);
            A0.SetSpriteVisible(false);
            A0.SpriteMoveTo(A0.GetSpritePositionX(),A0.GetSpritePositionY()-(float)8,60,true);
        }
    }

    // dOnKeyUp：键盘按键弹起后将被调用的方法
    // 参数 iKey：弹起的键，值见 enum KeyCodes 宏定义
    //
    public void	OnKeyUp( int iKey )
    {
        if (iKey == EnumDefine.KEY_A){
            A0.SetSpriteLinearVelocityX(0);
        }
        if (iKey == EnumDefine.KEY_D){
            A0.SetSpriteLinearVelocityX(0);
        }

        if (iKey == EnumDefine.KEY_W){
            ifjump = 0;
            A0.SetSpriteVisible(true);
            Ajump.SetSpriteVisible(false);
            A0.SetSpriteLinearVelocityY(30);
        }
    }

    // dOnSpriteColSprite：精灵与精灵碰撞后将被调用的方法
    // 精灵之间要产生碰撞，必须在编辑器或者代码里设置精灵发送及接受碰撞
    // 参数 szSrcName：发起碰撞的精灵名字
    // 参数 szTarName：被碰撞的精灵名字
    //
    public void	OnSpriteColSprite( String szSrcName, String szTarName )
    {
        if (szSrcName.indexOf("down") != -1){
            A0.SetSpriteLinearVelocityY(0);
            A0.SetSpritePositionY((float) (A0.GetSpritePositionY()-0.3));
        }

        if (szSrcName.indexOf("left") != -1 || szSrcName.indexOf("right") != -1){
//            A0.SetSpriteLinearVelocityX(0);
//            A0.SetSpritePositionX((float) (A0.GetSpritePositionX() - 0.1));
        }
    }

    // dOnSpriteColWorldLimit：精灵与世界边界碰撞后将被调用的方法
    // 精灵之间要产生碰撞，必须在编辑器或者代码里设置精灵的世界边界限制
    // 参数 szName：碰撞到边界的精灵名字
    // 参数 iColSide：碰撞到的边界 0 左边，1 右边，2 上边，3 下边
    //
    public void	OnSpriteColWorldLimit( String szName, int iColSide )
    {
    }

}
