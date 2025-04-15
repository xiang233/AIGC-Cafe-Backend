package com.aigccafe.buterin.common;

public interface Constant {
    // OOS
    String INTERNAL_ENDPOINT = "oss-cn-shanghai-internal.aliyuncs.com";
    String ETERNAL_ENDPOINT = "oss-cn-shanghai.aliyuncs.com";
    //String ACCESS_KEY_ID 
   // String ACCESS_KEY_SECRET 
    String IMAGE_BUCKET_NAME = "aigccafe";

    //
    String VERSION_IMAGE_DIR = "versions";

    String RESIZE_NORMAL = "image/auto-orient,1/resize,m_lfit,w_512/quality,q_90/format,jpeg";
    String LOGO_RESIZE = "image/auto-orient,1/resize,m_lfit,w_200/quality,q_90/format,jpeg";
    String COVERAGE_RESIZE = "image/auto-orient,1/resize,m_lfit,w_600/quality,q_90/format,jpeg";
    String USER_LOGO_DIR = "user_logo";
    String USER_COVERAGE_DIR = "user_cover";

    // CDN
    String CDN_HOST = "https://cdn.aigccafe.com";

    // BAIDU - API
    //String BAIDU_APP_ID 
   // String BAIDU_SECRET_KEY 

    // 系统默认头像
    String[] SYSTEM_AVATAR_LIST = {
            "https://cdn.aigccafe.com/user_avatar/20230610/QnwMQHvk_79111.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/vKfnlJZo_3910.gif",
            "https://cdn.aigccafe.com/user_avatar/20230610/pXTpgZSZ_23984.gif",
            "https://cdn.aigccafe.com/user_avatar/20230610/vyIRoWxE_85263.gif",
            "https://cdn.aigccafe.com/user_avatar/20230610/NkGgGBCa_99772.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/TYjJYbAI_14541.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/oIPTSrhs_26314.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/fxKSpEpM_37150.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/cWmcdRCs_49232.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/tgconDpK_60322.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/CbbXkMNK_73223.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/wqDtVPuU_82844.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/msQVEFQy_94885.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/RSJoyGXy_5201.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/pZmyFrqk_15835.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/oCTSfbEk_29237.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/RPSBgkSW_41819.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/usGGXOen_52825.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/IUxqPGmf_64026.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/lNuxUlbI_79866.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/SQbAvrfw_91498.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/AEYeblwk_3972.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/tnGwqGgz_20657.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/KeWdRPKE_33481.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/NNhAQKxC_74616.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/vGLnHVlY_91256.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/wHtBefpF_8580.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/aZfIJZMC_24122.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/TXpsJgeH_49212.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/dZINiynx_63864.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/BDXvHxBu_77987.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/niicvKjm_91317.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/VuwmmauA_10188.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/PXPvYsoa_24382.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/TUpdIsHT_51206.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/uELtsIQo_65995.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/ynNJrRuZ_84306.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/mebWpwth_98619.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/sRGzSNpF_13584.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/pTEJlbXD_48077.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/xtVZftme_68327.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/Uiufenxv_81960.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230610/tvRBwdWh_93891.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230611/caoBARYU_9340.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230611/kPkKiDiV_26341.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230611/TxzmfsMH_39486.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230611/PfmrFdEM_50588.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230611/WUxWldcI_61449.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230611/YwMHBCXM_72536.jpg",
            "https://cdn.aigccafe.com/user_avatar/20230611/uEbUMDKE_84223.jpg"
    };
}
