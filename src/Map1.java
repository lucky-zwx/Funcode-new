import FunCode.JSprite;

public class Map1 {

    private JSprite A0;
    private JSprite Ajump;

    public Map1(){
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
            A0.SetSpriteLinearVelocityY(30);
        }

        if (iKey == EnumDefine.KEY_D){
            A0.SetSpriteLinearVelocityX(20);
            A0.SetSpriteFlipX(false);
            A0.SetSpriteLinearVelocityY(30);
        }

        if (iKey == EnumDefine.KEY_W){
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
        if (szSrcName.equals("Amap_down")){
            A0.SetSpriteLinearVelocityY(0);
            A0.SetSpritePositionY((float) 12.830);
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
