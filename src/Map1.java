import FunCode.*;

import java.util.Date;

public class Map1 {

    private int ifjump; //��Ծ��ʶ
    private long jumptime;  //��Ծͣ��ʱ��
    private JSprite A0; //����
    private JSprite Ajump;  //��Ծ����

    public Map1(){

        ifjump = 0;
        //��ʼ������
        A0 = new JSprite("A0");
        Ajump = new JSprite("Ajump0");
    }

    //==============================================================================
    //
    // ÿ�ֿ�ʼǰ���г�ʼ���������һ���������
    public void	GameInit()
    {
    }

    //==============================================================================
    //
    // ÿ����Ϸ������
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
    // ������Ϸ����
    public void	GameEnd()
    {
    }

    // dOnMouseMove������ƶ��󽫱����õķ���
    // ���� fMouseX, fMouseY��Ϊ��굱ǰ����
    //
    public void	OnMouseMove( float fMouseX, float fMouseY )
    {
    }

    // dOnMouseClick����갴�º󽫱����õķ���
    // ���� iMouseType����갴��ֵ���� enum MouseTypes ����
    // ���� fMouseX, fMouseY��Ϊ��굱ǰ����
    //
    public void	OnMouseClick( int iMouseType, float fMouseX, float fMouseY )
    {
    }

    // dOnMouseUp����굯��󽫱����õķ���
    // ���� iMouseType����갴��ֵ���� enum MouseTypes ����
    // ���� fMouseX, fMouseY��Ϊ��굱ǰ����
    //
    public void	OnMouseUp( int iMouseType, float fMouseX, float fMouseY )
    {
    }

    // dOnKeyDown�����̱����º󽫱����õķ���
    // ���� iKey�������µļ���ֵ�� enum KeyCodes �궨��
    // ���� bAltPress, bShiftPress��bCtrlPress�������ϵĹ��ܼ�Alt��Ctrl��Shift��ǰ�Ƿ�Ҳ���ڰ���״̬
    //
    public void	OnKeyDown( int iKey, boolean bAltPress, boolean bShiftPress, boolean bCtrlPress )
    {
        //�������ǵķ�ת
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

    // dOnKeyUp�����̰�������󽫱����õķ���
    // ���� iKey������ļ���ֵ�� enum KeyCodes �궨��
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

    // dOnSpriteColSprite�������뾫����ײ�󽫱����õķ���
    // ����֮��Ҫ������ײ�������ڱ༭�����ߴ��������þ��鷢�ͼ�������ײ
    // ���� szSrcName��������ײ�ľ�������
    // ���� szTarName������ײ�ľ�������
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

    // dOnSpriteColWorldLimit������������߽���ײ�󽫱����õķ���
    // ����֮��Ҫ������ײ�������ڱ༭�����ߴ��������þ��������߽�����
    // ���� szName����ײ���߽�ľ�������
    // ���� iColSide����ײ���ı߽� 0 ��ߣ�1 �ұߣ�2 �ϱߣ�3 �±�
    //
    public void	OnSpriteColWorldLimit( String szName, int iColSide )
    {
    }

}
