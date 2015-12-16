package cn.com.jinrizhushi.stock.util.customstockview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.com.jinrizhushi.stock.R;
import cn.com.jinrizhushi.stock.stock.model.StockFiveDayItemModel;
import cn.com.jinrizhushi.stock.stock.model.StockFiveDayModel;
import cn.com.jinrizhushi.stock.stock.model.StockLineModel;
import cn.com.jinrizhushi.stock.stock.model.StockPointModel;
import cn.com.jinrizhushi.stock.stock.model.StockTextModel;
import cn.com.jinrizhushi.stock.stock.viewmodel.StockFiveDayViewModel;
import cn.com.jinrizhushi.stock.util.Tools;

/**
 * 描述: 五日图
 * 作者: 刘倩
 * 日期: 15/12/15 10:53
 */
public class StockFiveDayView extends View {
    /**
     * 自定义控件的实际高度
     */
    private float realHeight;
    /**
     * 自定义控件的实际宽度
     */
    private float realWidth;
    /**
     * 图形的边距
     */
    private float STOCK_VIEW_MARGIN = 20;
    /**
     * 离上下的距离
     */
    private float STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM = 20;
    /**
     * 坐标离线的距离
     */
    private float STOCK_IDNEX_VIEW_MAIGIN_LINE = 10;
    /**
     * 底部柱状图占的比例
     */
    private float STOCK_VIEW_BOTTOM_LINE_PERCENT = 1F;
    /**
     * 将视图分段
     */
    public static int STOCK_VIEW_ALL_DEVIDE = 7;
    /**
     * 视图左右的间距
     */
    private int STOCK_VIEW_LEFT_RIGHT_MARGIN = 2;
    /**
     * 离左边的距离
     */
    private float STOCK_VIEW_LEFT_DISTANCE = STOCK_VIEW_LEFT_RIGHT_MARGIN * STOCK_VIEW_MARGIN;
    /**
     * 视图离左边的距离
     */
    private int STOCK_VIEW_LEFT_MARGIN = 2;
    /**
     * 纵坐标的数据
     */
    private String[] ordinateData;
    /**
     * 横坐标的数据
     */
    private String[] abscissaData;
    /**
     * 起始X
     */
    private float STOCK_VIEW_START_X = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_MARGIN;
    /**
     * 绘制纵坐标文本的List
     */
    private List<StockTextModel> listTextOridinate = new ArrayList<>();
    /**
     * 绘制横坐标文本的List
     */
    private List<StockTextModel> listTextAbscissa = new ArrayList<>();
    /**
     * 绘制线的List
     */
    private List<StockLineModel> listLine = new ArrayList<>();
    /**
     * 绘制点的List
     */
    private List<StockPointModel> listPoint = new ArrayList<>();
    /**
     * 显示的数据
     */
    private StockFiveDayViewModel viewModel;
    private StockFiveDayModel stockFiveDayModel;
    private List<StockFiveDayItemModel> listFiveDayItemModel = new ArrayList<>();
    private List<String> listDate = new ArrayList<>();
    /**
     * 是否显示红线
     */
    private boolean isShowRedLine = false;
    /**
     * 坐标值的列表
     */
    private List<StockTextModel> listCoordinate = new ArrayList<>();
    /**
     * 字体大小
     */
    private int STOCK_INDEX_FONT_SIZE = 24;
    /**
     * 字体长度
     */
    private int STOCK_INDEX_FONT_LENGH = 27;
    /**
     * 曲线的点
     */
    private static List<StockPointModel> listLinePoint = new ArrayList<>();


    public StockFiveDayView(Context context) {
        super(context);
    }

    public StockFiveDayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StockFiveDayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public StockFiveDayViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(StockFiveDayViewModel viewModel) {
        this.viewModel = viewModel;
        setListDate(viewModel.getStockFiveDayModel().getListDate());
        setListFiveDayItemModel(viewModel.getStockFiveDayModel().getListFiveDayItemModel());
    }

    public StockFiveDayModel getStockFiveDayModel() {
        return stockFiveDayModel;
    }

    public void setStockFiveDayModel(StockFiveDayModel stockFiveDayModel) {
        this.stockFiveDayModel = stockFiveDayModel;
    }

    public List<StockFiveDayItemModel> getListFiveDayItemModel() {
        return listFiveDayItemModel;
    }

    public void setListFiveDayItemModel(List<StockFiveDayItemModel> listFiveDayItemModel) {
        this.listFiveDayItemModel = listFiveDayItemModel;
    }

    public List<String> getListDate() {
        return listDate;
    }

    public void setListDate(List<String> listDate) {
        this.listDate = listDate;
    }

    public boolean isShowRedLine() {
        return isShowRedLine;
    }

    public void setIsShowRedLine(boolean isShowRedLine) {
        this.isShowRedLine = isShowRedLine;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        realWidth = MeasureSpec.getSize(widthMeasureSpec);
        realHeight = MeasureSpec.getSize(heightMeasureSpec);
        initPoint();
        initLinePoint();
    }

    /**
     * 初始化曲线的点坐标
     */
    private void initLinePoint() {
        Paint paint = new Paint();
        paint.setColor(viewModel.getLineColor());
        paint.setStrokeWidth(5);
        stockFiveDayModel = viewModel.getStockFiveDayModel();
        listDate = stockFiveDayModel.getListDate();
        listFiveDayItemModel = stockFiveDayModel.getListFiveDayItemModel();

        if (listDate != null && listDate.size() > 0) {
            List<StockFiveDayItemModel> listOneDay = new ArrayList<>();
            List<StockFiveDayItemModel> listTwoDay = new ArrayList<>();
            List<StockFiveDayItemModel> listThirdDay = new ArrayList<>();
            List<StockFiveDayItemModel> listFourDay = new ArrayList<>();
            List<StockFiveDayItemModel> listFiveDay = new ArrayList<>();
            for (int i = 0; i < listDate.size(); i++) {
                String date = listDate.get(i);
                for (int k = 0; k < getListFiveDayItemModel().size(); k++) {
                    StockFiveDayItemModel item = getListFiveDayItemModel().get(k);
                    if (item.getTime().contains(date)) {
                        if (i == 0) {
                            listOneDay.add(item);
                        } else if (i == 1) {
                            listTwoDay.add(item);
                        } else if (i == 2) {
                            listThirdDay.add(item);
                        } else if (i == 3) {
                            listFourDay.add(item);
                        } else if (i == 4) {
                            listFiveDay.add(item);
                        }
                    }
                }
            }

            List<List<StockFiveDayItemModel>> dayInfo = new ArrayList<>();
            dayInfo.add(listOneDay);
            dayInfo.add(listTwoDay);
            dayInfo.add(listThirdDay);
            dayInfo.add(listFourDay);
            dayInfo.add(listFiveDay);
            for (int q = 0;q<dayInfo.size();q++){
                List<StockFiveDayItemModel> info = dayInfo.get(q);
                if (info != null && info.size() > 0) {
                    littleDis = (realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN * 2)/5;
                    float everyDistance = littleDis / info.size();
                    for (int i = 0; i < info.size(); i++) {
                        StockFiveDayItemModel model = info.get(i);
                        String index = model.getIndex();//获得指数
                        StockPointModel itemModel = new StockPointModel();
                        float x = STOCK_VIEW_LEFT_RIGHT_MARGIN * STOCK_VIEW_MARGIN+littleDis*q+everyDistance*i;
                        itemModel.setStartX(x);
                        float hDistance = Float.parseFloat(viewModel.getStockFiveDayModel().getStockIndexMaxValue()) - Float.parseFloat(viewModel.getStockFiveDayModel().getStockIndexMinValue());
                        float yD = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * 4 / STOCK_VIEW_ALL_DEVIDE - 2 * STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM;
                        float distan = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * 4 / STOCK_VIEW_ALL_DEVIDE + STOCK_VIEW_LEFT_DISTANCE - STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM;
                        float stY = distan - yD / hDistance * (Float.parseFloat(index)-Float.parseFloat(viewModel.getStockFiveDayModel().getStockIndexMinValue()));
                        itemModel.setStartY(stY);
                        itemModel.setPaint(paint);
                        listLinePoint.add(itemModel);
                    }
                }

            }


        }

    }

    /**
     * 初始化图的点坐标
     */
    private void initPoint() {
        if (ordinateData != null && ordinateData.length > 0) {
            for (int i = 0; i < ordinateData.length; i++) {
                listTextOridinate.add(new StockTextModel(ordinateData[i]));
            }
        }
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.line_bg));
        float startX = 0f;
        float startY = 0f;

        for (int i = 0; i <= STOCK_VIEW_ALL_DEVIDE; i++) {
            StockLineModel point;
            if (i == 0) {
                startX = STOCK_VIEW_START_X;
                startY = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN;
                point = new StockLineModel(startX, startY, realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, paint);
                listLine.add(point);
                if (ordinateData != null && ordinateData.length > 0) {

                    listTextOridinate.get(0).setTvX(startX);
                    listTextOridinate.get(0).setTvY(startY);
                }


            } else if (i < (STOCK_VIEW_ALL_DEVIDE - 2) || i == STOCK_VIEW_ALL_DEVIDE) {
                if (i > 0 && i < (STOCK_VIEW_ALL_DEVIDE - 3)) {
                    startX = STOCK_VIEW_START_X;
                    startY = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * i / STOCK_VIEW_ALL_DEVIDE + STOCK_VIEW_LEFT_DISTANCE;
                    if (ordinateData != null && ordinateData.length > 0) {

                        listTextOridinate.get(i).setTvX(startX);
                        listTextOridinate.get(i).setTvY(startY);
                    }
                    if (i == 2) {
                        drawPoint(startY, 2.0f);

                    }
                } else {
                    startY = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * i / STOCK_VIEW_ALL_DEVIDE + STOCK_VIEW_LEFT_DISTANCE;
                    startX = STOCK_VIEW_START_X;
                    point = new StockLineModel(startX, startY, realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, startY, paint);
                    listLine.add(point);
                    if (i != STOCK_VIEW_ALL_DEVIDE) {
                        if (ordinateData != null && ordinateData.length > 0) {

                            listTextOridinate.get(i).setTvX(startX);
                            listTextOridinate.get(i).setTvY(startY);
                        }
                    }
                    if (i == (STOCK_VIEW_ALL_DEVIDE - 3)) {
                        StockLineModel lineLeft = new StockLineModel(STOCK_VIEW_START_X, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, STOCK_VIEW_START_X, startY, paint);
                        listLine.add(lineLeft);
                        StockLineModel lineRight = new StockLineModel(realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, startY, paint);
                        listLine.add(lineRight);

                    }
                }

            } else if (i == (STOCK_VIEW_ALL_DEVIDE - 2)) {
                startX = STOCK_VIEW_START_X;
                startY = (realHeight - STOCK_VIEW_LEFT_DISTANCE) - (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * STOCK_VIEW_LEFT_RIGHT_MARGIN / STOCK_VIEW_ALL_DEVIDE * STOCK_VIEW_BOTTOM_LINE_PERCENT;
                point = new StockLineModel(startX, startY, realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, startY, paint);
                listLine.add(point);

            } else if (i == (STOCK_VIEW_ALL_DEVIDE - 1)) {
                startY = (realHeight - STOCK_VIEW_LEFT_DISTANCE) - (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * 2 / STOCK_VIEW_ALL_DEVIDE * STOCK_VIEW_BOTTOM_LINE_PERCENT / 2;
                startX = STOCK_VIEW_START_X;
                if (ordinateData != null && ordinateData.length > 0) {

                    listTextOridinate.get(STOCK_VIEW_ALL_DEVIDE - 2).setTvX(startX);
                    listTextOridinate.get(STOCK_VIEW_ALL_DEVIDE - 2).setTvY(startY);
                }
            }
        }
        StockLineModel point;
        float yPointLeft = (realHeight - STOCK_VIEW_LEFT_DISTANCE) - (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * 2 / STOCK_VIEW_ALL_DEVIDE * STOCK_VIEW_BOTTOM_LINE_PERCENT;
        float yPointRight = realHeight - STOCK_VIEW_LEFT_DISTANCE;
        point = new StockLineModel(STOCK_VIEW_START_X, yPointRight, STOCK_VIEW_START_X, yPointLeft, paint);
        listLine.add(point);
        point = new StockLineModel(realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, yPointRight, realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, yPointLeft, paint);
        listLine.add(point);
        addExtraLines();
    }

    float littleDis = 0f;

    /**
     * 添加额外的线
     */
    private void addExtraLines() {
        Paint paint = new Paint();
        paint.setTextSize(STOCK_INDEX_FONT_SIZE);
        if(viewModel!=null){
            paint.setColor(viewModel.getMaxIndexColor());
        }
        Paint paintlow = new Paint();
        paintlow.setTextSize(STOCK_INDEX_FONT_SIZE);
        if(viewModel!=null){
            paintlow.setColor(viewModel.getMinIndexColor());
        }
        float allWidth = realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN * 2;
        float dis = allWidth / 2;
        float startx = dis + STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN;
        float starty = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * 4 / STOCK_VIEW_ALL_DEVIDE + STOCK_VIEW_LEFT_DISTANCE;
        if (listDate != null && listDate.size() > 0 ) {
            Paint paintDate = new Paint();
            paintDate.setTextSize(STOCK_INDEX_FONT_SIZE);
            float littleDis = allWidth / 5;
            for (int i = 1; i <= 4; i++) {
                float startxs = littleDis * i + STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN;
                addLine(startxs, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, startxs, starty);
                listCoordinate.add(new StockTextModel(listDate.get(i), startxs - STOCK_INDEX_FONT_LENGH, Tools.getDecimalFormatFloat((float) (starty + STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM * 1.8)), paintDate));
            }

        } else {
            Paint paintDate = new Paint();
            paintDate.setTextSize(STOCK_INDEX_FONT_SIZE);
            addLine(startx, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, startx, starty);
            listCoordinate.add(new StockTextModel("09:30", STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, Tools.getDecimalFormatFloat((float) (starty + STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM * 1.8)), paintDate));
            listCoordinate.add(new StockTextModel("13:00", startx - STOCK_INDEX_FONT_LENGH, Tools.getDecimalFormatFloat((float) (starty + STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM * 1.8)), paintDate));
            listCoordinate.add(new StockTextModel("15:00", realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN - STOCK_INDEX_FONT_LENGH * 2, Tools.getDecimalFormatFloat((float) (starty + STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM * 1.8)), paintDate));
        }
        float highStartY = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN + STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM;
        addLine(STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, highStartY, realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, highStartY);
        float startY = (realHeight - STOCK_VIEW_LEFT_DISTANCE) - (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * STOCK_VIEW_LEFT_RIGHT_MARGIN / STOCK_VIEW_ALL_DEVIDE * STOCK_VIEW_BOTTOM_LINE_PERCENT;

        if (viewModel != null) {
            listCoordinate.add(new StockTextModel(viewModel.getStockFiveDayModel().getStockIndexMaxValue(), STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN + STOCK_IDNEX_VIEW_MAIGIN_LINE, highStartY + STOCK_IDNEX_VIEW_MAIGIN_LINE * 2 + 5, paint));
            listCoordinate.add(new StockTextModel(viewModel.getQoteChangeHigh(), realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN - STOCK_IDNEX_VIEW_MAIGIN_LINE * 7, highStartY + STOCK_IDNEX_VIEW_MAIGIN_LINE * 2 + 5, paint));
            float startyy = starty - STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM - STOCK_IDNEX_VIEW_MAIGIN_LINE;
            listCoordinate.add(new StockTextModel(viewModel.getStockFiveDayModel().getStockIndexMinValue(), STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN + STOCK_IDNEX_VIEW_MAIGIN_LINE, startyy, paintlow));
            float startxx = realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN - STOCK_IDNEX_VIEW_MAIGIN_LINE * 8;
            listCoordinate.add(new StockTextModel(viewModel.getQoteChangeLow(), startxx, startyy, paintlow));
            Paint paintVolume = new Paint();
            paintVolume.setTextSize(STOCK_INDEX_FONT_SIZE);
            listCoordinate.add(new StockTextModel(viewModel.getHighestVolume(), realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN - STOCK_IDNEX_VIEW_MAIGIN_LINE * 2, startY + STOCK_IDNEX_VIEW_MAIGIN_LINE * 2 + 5, paintVolume));

        } else {
            listCoordinate.add(new StockTextModel("0", STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN + STOCK_IDNEX_VIEW_MAIGIN_LINE, highStartY + STOCK_IDNEX_VIEW_MAIGIN_LINE * 2 + 5, paint));
            listCoordinate.add(new StockTextModel("0", realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN - STOCK_IDNEX_VIEW_MAIGIN_LINE * 2, highStartY + STOCK_IDNEX_VIEW_MAIGIN_LINE * 2 + 5, paint));
            float startyy = starty - STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM - STOCK_IDNEX_VIEW_MAIGIN_LINE;
            listCoordinate.add(new StockTextModel("0", STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN + STOCK_IDNEX_VIEW_MAIGIN_LINE, startyy, paintlow));
            float startxx = realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN - STOCK_IDNEX_VIEW_MAIGIN_LINE * 2;
            listCoordinate.add(new StockTextModel("0", startxx, startyy, paintlow));
            Paint paintVolume = new Paint();
            paintVolume.setTextSize(STOCK_INDEX_FONT_SIZE);
            listCoordinate.add(new StockTextModel("0", realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN - STOCK_IDNEX_VIEW_MAIGIN_LINE * 2, startY + STOCK_IDNEX_VIEW_MAIGIN_LINE * 2 + 5, paintVolume));
        }

        highStartY = starty - STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM;
        addLine(STOCK_VIEW_START_X, highStartY, realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, highStartY);
    }

    private void addLine(float startx, float starty, float stopx, float stopy) {
        Paint paints = new Paint();
        paints.setColor(getResources().getColor(R.color.stock_view_index_line_color));
        paints.setStrokeWidth(2);
        StockLineModel point;
        point = new StockLineModel(startx, starty, stopx, stopy, paints);
        listLine.add(point);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < listLine.size(); i++) {
            StockLineModel point = listLine.get(i);
            canvas.drawLine(point.getStartX(), point.getStartY(), point.getStopX(), point.getStopY(), point.getPaint());
        }
        setRedLine(canvas);
        drawTexts(canvas);
        drawLine(canvas);
    }

    /**
     * 画曲线
     * @param canvas
     */
    private void drawLine(Canvas canvas) {

        Path path = new Path();
        for (int i = (listLinePoint.size() - 1); i > 0; i--) {
            StockPointModel modelBehind = listLinePoint.get(i);
            StockPointModel modelAHead = listLinePoint.get(i - 1);
            Paint paint = modelAHead.getPaint();
            paint.setStrokeWidth(3);
            if (i == (listLinePoint.size() - 1)) {
                path.moveTo(modelBehind.getStartX(), modelBehind.getStartY());
            } else {
                path.lineTo(modelBehind.getStartX(), modelBehind.getStartY());
                path.lineTo(modelAHead.getStartX(), modelAHead.getStartY());
            }
            canvas.drawLine(modelAHead.getStartX(), modelAHead.getStartY(), modelBehind.getStartX(), modelBehind.getStartY(), paint);

        }
    }

    private void drawTexts(Canvas canvas) {
        if (listCoordinate != null && listCoordinate.size() > 0) {
            for (int i = 0; i < listCoordinate.size(); i++) {
                StockTextModel model = listCoordinate.get(i);
                canvas.drawText(model.getContent(), model.getTvX(), model.getTvY(), model.getPaint());
            }
        }
    }

    private void setRedLine(Canvas canvas) {
        if (isShowRedLine) {
            for (int i = 0; i < listPoint.size(); i++) {
                StockPointModel point = listPoint.get(i);
                canvas.drawPoint(point.getStartX(), point.getStartY(), point.getPaint());
            }
        }
    }

    /**
     * 画点
     *
     * @param pointY 该点所在的坐标
     * @param width  该点所在的半径
     */
    private void drawPoint(float pointY, float width) {

        float startY = pointY;
        int stop = (int) (realWidth - STOCK_VIEW_LEFT_DISTANCE);
        float sum = STOCK_VIEW_START_X;
        for (int k = 0; k < stop; k++) {
            sum = sum + 5;
            Paint paintPoint = new Paint();
            paintPoint.setColor(getResources().getColor(R.color.stock_view_point_bg));
            if (sum < (realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN)) {
                paintPoint.setStrokeWidth(width);
                StockPointModel newPoint = new StockPointModel(sum, startY, paintPoint);
                listPoint.add(newPoint);
            }
        }
    }
}
