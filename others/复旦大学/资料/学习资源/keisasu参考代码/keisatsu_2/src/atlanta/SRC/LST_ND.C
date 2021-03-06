/*************************************************************************
*	System		: SAKAKI
*	File Name	: LST_MCR.C
*	Author		: 桑原 美紀
*	Date		: 1998/05/20
*	RealTimeOS	: ＲＩＳＣ（ＳＨ７０４３）モニター
*	Description	: ナンバーディスプレイリスト
*	Maintenance	: 
*
*	Copyright (C) 1996 Murata Machinery,Ltd. All rights reserved.
*************************************************************************/
#include	"\src\atlanta\define\product.h"
#include	"\src\atlanta\define\apl_msg.h"
#include	"\src\atlanta\define\std.h"
#include	"\src\atlanta\define\sysdial.h"
#include	"\src\atlanta\define\syswarp.h"

#include	"\src\atlanta\define\cmn_def.h"
#include	"\src\atlanta\define\lst_def.h"

#include	"\src\atlanta\define\cmn_pro.h"
#include	"\src\atlanta\define\lst_pro.h"
#include	"\src\atlanta\define\uni_pro.h"

#include	"\src\atlanta\ext_v\bkupram.h"
#include	"\src\atlanta\ext_v\lst_data.h"
#include	"\src\atlanta\ext_v\lst_wrd.h"

#if (PRO_NUMBER_DISPLAY == ENABLE)	/* 1998/06/24 By M.Kuwahara */

struct SYS_DialData_t	LST_ND_Dial;	/* ダイヤル番号出力ワーク */

/*************************************************************************
	module		:[ナンバーディスプレイリスト]
	function	:[ナンバーディスプレイリストを印刷する]
	common		:[
		List		:
		SYB_KeyMacro
	]
	condition	:[]
	commment	:[]
	return		:[印刷結果]
	machine		:[SH7043]
	language	:[SHC]
	keyword		:[LST]
	date		:[98/05/19]
	author		:[桑原美紀]
*************************************************************************/
WORD				Print_ND_List(
						 void )				/*なし*/
{
	UBYTE	i;						/*loop*/
	UBYTE 	page;					/*ﾍﾟｰｼﾞ*/
	UBYTE	nd_cnt;					/*ﾅﾝﾊﾞｰﾃﾞｨｽﾌﾟﾚｲﾃﾞｰﾀ番号*/
	UBYTE 	line_cnt;				/*残り印刷可能行数*/
	UBYTE	item;					/* 出力綱目番号 */
	register WORD	ret;			/*実行結果*/

	i		= 0;
	page 	= 1;
	nd_cnt	= 0;
	item	= 0;
	DialCheckPointer	= SYS_DIRECT_DIAL;
	DialCheckBitPointer	= 0;

	nd_cnt = ND_DataNextSearch( nd_cnt );	/*次ﾃﾞｰﾀｻｰﾁ */
	if ( nd_cnt == SYS_ND_MAX ) {
		return ( MSG_PRN_LST_NO_LIST );
	}
	while ( nd_cnt != SYS_ND_MAX ) {
		if ( (ret = CharacterPrint( LST_OPEN )) != OK ) {
			return ( ret );
		}

		if ( page == 1 ) {
			line_cnt = (UBYTE)(PaperSizeLen() - 11);/*印刷可能行数ｾｯﾄ*/
		}
		else {
			line_cnt = (UBYTE)(PaperSizeLen() - 4);/*印刷可能行数ｾｯﾄ*/
		}
		if ( (ret = Print_ND_List_Head( 0, page ) ) != OK ) {/*ﾍｯﾀﾞ印刷*/
			return ( ret );
		}

		for (;;) {
			/*印刷予定行数が印刷可能か判断*/
			/* １明細印刷 */
			if ((item == 0) && 	/* １明細の先頭行 */
				(line_cnt <= 1)) {
				break;
			}
			if ( (ret = Print_ND_List_Specifi( &item, page ,&i, nd_cnt, &line_cnt) ) != OK ) {
				return (ret);
			}
			if (item == 0) {	/* 次の明細を検索 */
				nd_cnt++;
				nd_cnt = ND_DataNextSearch( nd_cnt );	/*次ﾃﾞｰﾀｻｰﾁ */
				if (nd_cnt == SYS_ND_MAX) {
					break;
				}
				DialCheckPointer	= SYS_DIRECT_DIAL;
				i	= 0;
			}
			if (line_cnt <= 0) {
				break;
			}
		}
		if ( (ret = Print_ND_List_Head( 1, page) ) != OK ) {	/*ﾌｯﾀ印刷*/
			return (ret);
		}

		if ( (ret = CharacterPrint( LST_CLOSE )) != OK ) {
			return (ret);
		}
		page++;
	}
	return ( OK );
}

/*************************************************************************
	module		:[ナンバーディスプレイヘッダ印刷]
	functiom	:[ナンバーディスプレイのヘッダを印刷する]
	common		:[
		List	:
	]
	condition	:[
		ﾍｯﾀﾞ種類
			0->ﾍﾟｰｼﾞ先頭見出し
			1->ﾍﾟｰｼﾞｴﾝﾄﾞ見出し
	]
	commment	:[]
	return		:[印刷結果]
	machine		:[SH7043]
	language	:[SHC]
	keyword		:[LST]
	date		:[98/06/08]
	author		:[桑原美紀]
*************************************************************************/
WORD				Print_ND_List_Head(
						 UBYTE Category,	/*ヘッダ種類*/
						 UBYTE Page )		/*ページ*/
{
	register WORD	ret;					/*実行結果*/

	if ( Category == 0 ) {
		if ( Page == 1 ) {

			/*１改行＋発信元名、番号印刷＋２改行＋見出し＋１改行*/
#if ( PRO_PANEL == KANJI ) || ( PRO_JIS_CODE == ENABLE )
			if ( (ret = Print_Head1_Common( PWRD_NumberDisplayList_K,
			 LST_NOT, 15-1 )) != OK ) {
				return ( ret );
			}
#else
			if ( (ret = Print_Head1_Common( PWRD_NumberDisplayList,
			  LST_XXX_TWI_XXX, 15-1 )) != OK ) {
				return ( ret );
			}
#endif
			/*現在時間*/
			/*Page 現在時間*/
			if ( (ret = PageTimePrint( Page, 6-1, 55-1 )) != OK ) {
				return ( ret );
			}

			/*�ｮ�｢�ﾎ�｢�｢�｢�｢�｢�ｲ*/
			Print_ND_List_Line( 0, List.S.Print, List.S.Attribute );
			if ( (ret = CharacterPrint( LST_PRINT )) != OK ) {
				return ( ret );
			}

			/*�､相手先名�､  ﾀﾞｲﾔﾙ番号   �､*/
			Print_ND_List_Line( 1, List.S.Print, List.S.Attribute );
			if ( (ret = CharacterPrint( LST_PRINT )) != OK ) {
				return ( ret );
			}
		}
		else {
			/*１行印字（改行）*/
			if ( (ret = CharacterPrint( LST_LINE_FEED )) != OK ) {
				return ( ret );
			}
			/* Page */
			if ( (ret = PagePrint( Page, 6-1 )) != OK ) {
				return ( ret );
			}
		}
	}
	else {
		/*�ｶ�｢�｢�ﾖ�｢�｢�｢�｢�ｺ*/
		Print_ND_List_Line( 4, List.S.Print, List.S.Attribute );
		if ( (ret = CharacterPrint( LST_PRINT )) != OK ) {
			return ( ret );
		}

		/*１行印字（改行）*/
		if ( (ret = CharacterPrint( LST_LINE_FEED )) != OK ) {
			return ( ret );
		}
	}
	return( OK );
}


/*************************************************************************
	module		:[ナンバーディスプレイダイヤル ネクスト サーチ］
	functiom	:[ナンバーディスプレイダイヤルの次をサーチする]
	common		:[
		SYB_NumberDisplay	:
	]
	condition	:[
		,	データエンド->SYS_ND_MAX
	]
	commment	:[]
	return		:[なし]
	machine		:[SH7043]
	language	:[SHC]
	keyword		:[LST]
	date		:[98/06/08]
	author		:[桑原美紀]
*************************************************************************/
UBYTE		ND_DataNextSearch(
					 UBYTE ND_Cnt)	/*ワンタッチダイヤルデータ番号*/
{
	UBYTE	i;

	for (i = ND_Cnt; i < SYS_ND_MAX; i++) {
		if (SYB_NumberDisplay[i].Dial[0] != '\0') {
			break;
		}
	}
	return (i);
}


/*************************************************************************
	module		:[ナンバーディスプレイの１明細印刷]
	functiom	:[ナンバーディスプレイの１明細を印刷する。]
	common		:[
		List				:
		SYB_NumberDisplay		:
	]
	condition	:[
	]
	commment	:[]
	return		:[印刷結果]
	machine		:[SH7043]
	language	:[SHC]
	keyword		:[LST]
	date		:[98/06/08]
	author		:[桑原美紀]
*************************************************************************/
WORD			Print_ND_List_Specifi(
					 UBYTE *Item,		/* 出力項目 */
					 UBYTE Page,		/*ページ*/
					 UBYTE *Line,		/*現在明細数*/
					 UBYTE ND_Cnt,		/*データ番号*/
					 UBYTE *LineCnt )	/*印字行位置*/
{
	UBYTE	i;
	UBYTE	check_line;
	register WORD	ret;					/*実行結果*/

	check_line = (UBYTE)(PaperSizeLen() - 4);

	if ((Page > 1) &&	/* ２ページ目以降の先頭行の時 */
		(*LineCnt == (PaperSizeLen() - 4))) {
		/*�ｾ�｢�｢�ﾞ�｢�｢�｢�ﾆ*/
		Print_ND_List_Line( 0, List.S.Print, List.S.Attribute );
		if ( (ret = CharacterPrint( LST_PRINT )) != OK ) {
			return ( ret );
		}
		(*LineCnt)--;
	}
	else {
		if (*Item == 0) {	/* 相手先名、ﾀﾞｲﾔﾙ番号出力 */
			/*�ｾ�｢�｢�ﾞ�｢�｢�｢�ﾆ*/
			Print_ND_List_Line( 2, List.S.Print, List.S.Attribute );
			if ( (ret = CharacterPrint( LST_PRINT )) != OK ) {
				return ( ret );
			}
			(*LineCnt)--;
		}
	}

	/* ワーク用のデータセット */
	for (i = 0; i < SYS_COM_DIRECT_DIAL_MAX ; i++) {
		LST_ND_Dial.Direct[i][0] = 0xFF;
	}
	CMN_StringCopyNum((UBYTE *)&LST_ND_Dial.Direct[0],
						   SYB_NumberDisplay[ND_Cnt].WarpData.Direct,
						   SYS_DIRECT_DIAL_MAX );

	for (i = 0; i < SYS_ONETOUCH_BIT_FIELD_MAX; i++) {
		LST_ND_Dial.Onetouch[i] = SYB_NumberDisplay[ND_Cnt].WarpData.Onetouch[i];
	}
	for (i = 0; i < SYS_SPEED_BIT_FIELD_MAX; i++) {
		LST_ND_Dial.Speed[i] = SYB_NumberDisplay[ND_Cnt].WarpData.Speed[i];
	}
	LST_ND_Dial.Group = SYB_NumberDisplay[ND_Cnt].WarpData.Group;

	while( *LineCnt != 0 ){
		Print_ND_List_Line( 3, List.S.Print, List.S.Attribute );
		switch (*Item) {		/* 出力項目番号 */
		case	0:	/* No, 相手先名、ﾀﾞｲﾔﾙ番号出力 */
			/*�､xx�､xxxxxxx�､99999999999�､*/
			/** No. */
			CMN_UnsignedIntToASC( &List.S.Print[6-1], (UWORD)(ND_Cnt+1), 2, ' ' );
			/** 相手先名 */
			CMN_StringCopy( &List.S.Print[10-1], SYB_NumberDisplay[ND_Cnt].Name );
			/** ダイヤル番号 */
			CMN_StringCopy( &List.S.Print[35-1], SYB_NumberDisplay[ND_Cnt].Dial );
			if ( (ret = CharacterPrint( LST_PRINT )) != OK ) {
				return ( ret );
			}
			(*LineCnt)--;
			if (SYB_NumberDisplay[ND_Cnt].WarpData.Status == SYS_WARP_EMPTY) {
				(*Item) = 0;
				return( OK );
			}
			*Item = 1;
			break;
		case	1:	/* 転送先出力 */
			if (*Line == 0) {
				AttributeSet( &List.S.Print[10-1], &List.S.Attribute[10-1], PWRD_AltNo, LST_NOT );
			}
			/** ﾀﾞｲﾔﾙ番号の文字列変換 */
			ret = ProgramDataDialToString( (struct SYS_DialData_t *)&LST_ND_Dial, SYS_PRG_DIAL_MAX, List.S.Work, *Line );
			CMN_StringCopy( &List.S.Print[35-1], List.S.Work );
			if (DialCheckPointer == SYS_EMPTY_DIAL) {	/* 全明細内容出力 */
				(*Item) = 2;
			}
			else {
				(*Line)++;
			}
			if ( (ret = CharacterPrint( LST_PRINT )) != OK ) {
				return ( ret );
			}
			(*LineCnt)--;
			break;
		case	2:	/* 指定時刻出力 */
			/*�､(指定時刻)�､XXXXXXXXXXXXXXXXXXXX�､*/
			List.S.Print[10-1] = '(';
			AttributeSet( &List.S.Print[11-1], &List.S.Attribute[11-1], PWRD_AppointedTime, LST_NOT );
			List.S.Print[19-1] = ')';
			WarpTimeDataSet((struct SYS_SubDialData_t *)&SYB_NumberDisplay[ND_Cnt].WarpData, &List.S.Print[35-1] );
			if ( (ret = CharacterPrint( LST_PRINT )) != OK ) {
				return ( ret );
			}
			(*LineCnt)--;
			(*Item) = 3;
			break;
		case	3:	/* 同時ﾌﾟﾘﾝﾄ */
			/*�､(同時ﾌﾟﾘﾝﾄ)�､XXX                �､*/
			List.S.Print[10-1] = '(';
			AttributeSet( &List.S.Print[11-1], &List.S.Attribute[11-1], PWRD_RxPrint, LST_NOT );
			List.S.Print[21-1] = ')';
			if (SYB_NumberDisplay[ND_Cnt].WarpData.Option & WARP_OPTION_PRINT) {
				AttributeSet( &List.S.Print[35-1], &List.S.Attribute[35-1], PWRD_On, LST_NOT );
			}
			else {
				AttributeSet( &List.S.Print[35-1], &List.S.Attribute[35-1], PWRD_Off, LST_NOT );
			}
			if ( (ret = CharacterPrint( LST_PRINT )) != OK ) {
				return ( ret );
			}
			(*LineCnt)--;
			(*Item) = 0;
			return( OK );
			break;
		default:
			break;
		}
	}
	return( OK );
}


/*************************************************************************
	module		:[ナンバーディスプレイリストの横区切り罫線作成]
	function	:[ナンバーディスプレイリストの横区切り罫線を作成する。
	common		:[]
	condition	:[]
	commment	:[]
	return		:[印刷結果]
	machine		:[SH7043]
	language	:[SHC]
	keyword		:[LST]
	date		:[98/05/19]
	author		:[桑原美紀]
*************************************************************************/
void			Print_ND_List_Line(
						 UBYTE Category,			/*罫線種類*/
						 register UBYTE *AscString,	/*印刷文字列*/
						 register UBYTE *AttString )/*修飾文字列*/
{
	Prn_Att_Str_Clear( AscString, AttString );
	switch ( Category ) {
		case 0:
			/*�ｮ�｢�､�､�､�､�､�､�､�ﾎ�｢�｢�｢�｢�｢�ｲ*/
			AscString[5-1] = LST_KLINE7;
			CMN_MemorySet( &AscString[6-1], 69, LST_KLINE_ );
			AscString[9-1] = LST_KLINE8;
			AscString[34-1] = LST_KLINE8;
			AscString[75-1] = LST_KLINE9;
			break;
		case 1:
			/*�､No.�､相手先名�､  ﾀﾞｲﾔﾙ番号  �､*/
			AscString[5-1] = LST_KLINEI;
			AttributeSet( &AscString[6-1], &AttString[6-1], PWRD_No, LST_NOT );
			AscString[9-1] = LST_KLINEI;
			AttributeSet( &AscString[16-1], &AttString[16-1], PWRD_BoxLocation, LST_NOT );
			AscString[34-1] = LST_KLINEI;
			AttributeSet( &AscString[49-1], &AttString[49-1], PWRD_TelNum, LST_NOT );
			AscString[75-1] = LST_KLINEI;
			break;
		case 2:
			/*�ｾ�､�､�､�､�､�｢�｢�ﾞ�｢�｢�｢�ﾆ*/
			AscString[5-1] = LST_KLINE4;
			CMN_MemorySet( &AscString[6-1], 69, LST_KLINE_ );
			AscString[9-1] = LST_KLINE5;
			AscString[34-1] = LST_KLINE5;
			AscString[75-1] = LST_KLINE6;
			break;
		case 3:
			/*�､ �､       �､          �､*/
			AscString[5-1] = LST_KLINEI;
			AscString[9-1] = LST_KLINEI;
			AscString[34-1] = LST_KLINEI;
			AscString[75-1] = LST_KLINEI;
			break;
		case 4:
			/*�ｶ�｢�｢�ﾖ�｢�｢�｢�｢�ｺ�､�､�､�､*/
			AscString[5-1] = LST_KLINE1;
			CMN_MemorySet( &AscString[6-1], 69, LST_KLINE_ );
			AscString[9-1] = LST_KLINE2;
			AscString[34-1] = LST_KLINE2;
			AscString[75-1] = LST_KLINE3;
			break;
	}
}

#endif
