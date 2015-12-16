package cn.com.jinrizhushi.stock.util.customstockview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.com.jinrizhushi.stock.R;
import cn.com.jinrizhushi.stock.stock.model.StockFiveDayItemModel;
import cn.com.jinrizhushi.stock.stock.model.StockFiveDayModel;
import cn.com.jinrizhushi.stock.stock.model.StockLineModel;
import cn.com.jinrizhushi.stock.stock.model.StockPointModel;
import cn.com.jinrizhushi.stock.stock.model.StockRectModel;
import cn.com.jinrizhushi.stock.stock.model.StockTextModel;
import cn.com.jinrizhushi.stock.stock.viewmodel.StockFiveDayViewModel;
import cn.com.jinrizhushi.stock.stock.viewmodel.StockMarketIndexViewModel;
import cn.com.jinrizhushi.stock.util.Tools;

/**
 * 描述: 五日图
 * 作者: 刘倩
 * 日期: 15/12/15 10:53
 */
public class StockMinuteView extends View {
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
    /**
     * 是否显示红线
     */
    private boolean isShowRedLine = true;
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
    /**
     * 长方形的数组
     */
    private List<StockRectModel> listRectPoint = new ArrayList<>();
    /**
     * 成交量的数组
     */
    private List<String> listVolume = new ArrayList<>();


    public StockMinuteView(Context context) {
        super(context);
    }

    public StockMinuteView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StockMinuteView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public StockFiveDayViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(StockFiveDayViewModel viewModel) {
        this.viewModel = viewModel;
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        realWidth = MeasureSpec.getSize(widthMeasureSpec);
        realHeight = MeasureSpec.getSize(heightMeasureSpec);
        initPoint();
        initLinePoint();
        initBarPoint();
    }

    /**
     * 初始化柱状图的坐标
     */
    private void initBarPoint() {
        if (listRectPoint != null && listRectPoint.size() > 0) {
            listRectPoint.clear();
        }
        if (listFiveDayItemModel != null && listFiveDayItemModel.size() > 0) {
            float allWidth = realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN * 2;
            float allHeight = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * 2 / STOCK_VIEW_ALL_DEVIDE;
            if (listFiveDayItemModel != null && listFiveDayItemModel.size() > 0) {
                for (int i = 0; i < listFiveDayItemModel.size(); i++) {
                    listVolume.add(listFiveDayItemModel.get(i).getVolume());
                }
            }
            float maxVolume = Float.parseFloat(viewModel.getHighestVolume());
            float yDisdance = allHeight / maxVolume;
            float xDistance = allWidth / listFiveDayItemModel.size();
            float startx = realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN;
            float starty = realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * STOCK_VIEW_MARGIN;
            for (int i = (listVolume.size() - 1); i >= 0; i--) {
                float volume = Float.parseFloat(listVolume.get(i));
                StockRectModel model = new StockRectModel();
                model.setRight(startx - xDistance * i);
                model.setTop(starty - volume * yDisdance + STOCK_IDNEX_VIEW_MAIGIN_LINE);
                model.setLeft(startx - (float) (xDistance * (i + 0.2)));
                model.setBottom(starty);
                if ((startx - (float) (xDistance * (i + 0.2))) >= STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN) {
                    listRectPoint.add(model);
                }
            }


        }
    }

    /**
     * 初始化曲线的点坐标
     */
    private void initLinePoint() {
        Paint paint = new Paint();
        paint.setColor(viewModel.getLineColor());
        paint.setStrokeWidth(5);
        stockFiveDayModel = viewModel.getStockFiveDayModel();
        listFiveDayItemModel = stockFiveDayModel.getListFiveDayItemModel();
        float startx = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN;
        float starty = timeY - STOCK_IDNEX_VIEW_MAIGIN_LINE;
        float xDistance = (realWidth - startx * 2) / (4 * 60);
        float yDistance = (timeY - startx) / (Float.parseFloat(viewModel.getStockFiveDayModel().getStockIndexMaxValue()) - Float.parseFloat(viewModel.getStockFiveDayModel().getStockIndexMinValue()));
        float startTime = getAll("09:30");
        float centerUpTime = getAll("11:30");
        float centerTime = getAll("13:00");
        float stopTime = getAll("15:00");
        if (listFiveDayItemModel != null && listFiveDayItemModel.size() > 0) {
            for (int i = 0; i < listFiveDayItemModel.size(); i++) {
                StockFiveDayItemModel model = listFiveDayItemModel.get(i);
                String index = model.getIndex();
                String time = model.getTime();
                StockPointModel itemModel = new StockPointModel();
                float current = getAll(time);
                float allX = 0f;
                if (current <= centerUpTime) {
                    allX = (current - startTime) * xDistance;
                } else if(current == stopTime){
                    allX = realWidth - startx * 2;
                }else if(current == centerUpTime||current == centerTime){
                    allX = realWidth/2+startx;
                }else{
                    allX = (current - centerTime) * xDistance + (centerUpTime-startTime) *xDistance;
                }

                itemModel.setStartX(startx + allX);
                float endY = starty - ((Float.parseFloat(index) - Float.parseFloat(viewModel.getStockFiveDayModel().getStockIndexMinValue()))) * yDistance;
                itemModel.setStartY(endY);
                Paint paints = new Paint();
                paints.setStrokeWidth(5);
                paints.setColor(viewModel.getLineColor());
                itemModel.setPaint(paints);
                listLinePoint.add(itemModel);
            }
        }
    }

    /**
     * 返回秒
     *
     * @param time
     * @return
     */
    private float getAll(String time) {
        String s1 = time.substring(0, 2);
        String s2 = time.substring(3, 5);
        return Float.parseFloat(s1) * 60 + Float.parseFloat(s2);
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
    float timeY = 0f;

    /**
     * 添加额外的线
     */
    private void addExtraLines() {
        Paint paint = new Paint();
        paint.setTextSize(STOCK_INDEX_FONT_SIZE);
        if (viewModel != null) {
            paint.setColor(viewModel.getMaxIndexColor());
        }
        Paint paintlow = new Paint();
        paintlow.setTextSize(STOCK_INDEX_FONT_SIZE);
        if (viewModel != null) {
            paintlow.setColor(viewModel.getMinIndexColor());
        }
        float allWidth = realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN * 2;
        float dis = allWidth / 2;
        float startx = dis + STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN;
        float starty = (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * 4 / STOCK_VIEW_ALL_DEVIDE + STOCK_VIEW_LEFT_DISTANCE;
        Paint paintDate = new Paint();
        paintDate.setTextSize(STOCK_INDEX_FONT_SIZE);
        addLine(startx, STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, startx, starty);
        listCoordinate.add(new StockTextModel("09:30", STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, Tools.getDecimalFormatFloat((float) (starty + STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM * 1.8)), paintDate));
        listCoordinate.add(new StockTextModel("13:00", startx - STOCK_INDEX_FONT_LENGH, Tools.getDecimalFormatFloat((float) (starty + STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM * 1.8)), paintDate));
        listCoordinate.add(new StockTextModel("15:00", realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN - STOCK_INDEX_FONT_LENGH * 2, Tools.getDecimalFormatFloat((float) (starty + STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM * 1.8)), paintDate));

        float highStartY = STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN + STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM;
        addLine(STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, highStartY, realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, highStartY);
        float startY = (realHeight - STOCK_VIEW_LEFT_DISTANCE) - (realHeight - STOCK_VIEW_LEFT_RIGHT_MARGIN * 2 * STOCK_VIEW_MARGIN) * STOCK_VIEW_LEFT_RIGHT_MARGIN / STOCK_VIEW_ALL_DEVIDE * STOCK_VIEW_BOTTOM_LINE_PERCENT;
        timeY = starty;
        if (viewModel != null) {
            listCoordinate.add(new StockTextModel(viewModel.getStockFiveDayModel().getStockIndexMaxValue(), STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN + STOCK_IDNEX_VIEW_MAIGIN_LINE, highStartY + STOCK_IDNEX_VIEW_MAIGIN_LINE * 2 + 5, paint));
            listCoordinate.add(new StockTextModel(viewModel.getQoteChangeHigh(), realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN - STOCK_IDNEX_VIEW_MAIGIN_LINE * 7, highStartY + STOCK_IDNEX_VIEW_MAIGIN_LINE * 2 + 5, paint));
            float startyy = starty - STOCK_INDEX_VIEW_MARGIN_TOP_BOTTOM - STOCK_IDNEX_VIEW_MAIGIN_LINE;
            listCoordinate.add(new StockTextModel(viewModel.getStockFiveDayModel().getStockIndexMinValue(), STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN + STOCK_IDNEX_VIEW_MAIGIN_LINE, startyy, paintlow));
            float startxx = realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN - STOCK_IDNEX_VIEW_MAIGIN_LINE * 8;
            listCoordinate.add(new StockTextModel(viewModel.getQoteChangeLow(), startxx, startyy, paintlow));
            Paint paintVolume = new Paint();
            paintVolume.setTextSize(STOCK_INDEX_FONT_SIZE);
            listCoordinate.add(new StockTextModel(viewModel.getHighestVolume(), realWidth - STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN - STOCK_IDNEX_VIEW_MAIGIN_LINE * 5, startY + STOCK_IDNEX_VIEW_MAIGIN_LINE * 2 + 5, paintVolume));

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
        drawLine(canvas);
        for (int i = 0; i < listLine.size(); i++) {
            StockLineModel point = listLine.get(i);
            canvas.drawLine(point.getStartX(), point.getStartY(), point.getStopX(), point.getStopY(), point.getPaint());
        }
        setRedLine(canvas);
        drawTexts(canvas);
        drawBarChart(canvas);
    }

    /**
     * 画成交量的柱状图
     *
     * @param canvas
     */
    private void drawBarChart(Canvas canvas) {
        if (listRectPoint != null && listRectPoint.size() > 0) {
            for (int i = 0; i < listRectPoint.size(); i++) {
                StockRectModel model = listRectPoint.get(i);
                Paint paint = new Paint();
                paint.setColor(viewModel.getVolumeColor());
                canvas.drawRect(model.getLeft(), model.getTop(), model.getRight(), model.getBottom(), paint);
            }
        }
    }

    /**
     * 画曲线
     *
     * @param canvas
     */
    private void drawLine(Canvas canvas) {
        if (listLinePoint != null && listLinePoint.size() > 0) {
            Path path = new Path();
            for (int i = (listLinePoint.size() - 1); i > 0; i--) {
                StockPointModel modelBehind = listLinePoint.get(i);
                StockPointModel modelAHead = listLinePoint.get(i - 1);
                Paint paint = modelAHead.getPaint();
                paint.setStrokeWidth(5);
                if (i == (listLinePoint.size() - 1)) {
                    path.moveTo(modelBehind.getStartX(), modelBehind.getStartY());
                } else {
                    path.lineTo(modelBehind.getStartX(), modelBehind.getStartY());
                    path.lineTo(modelAHead.getStartX(), modelAHead.getStartY());
                }
                canvas.drawLine(modelAHead.getStartX(), modelAHead.getStartY(), modelBehind.getStartX(), modelBehind.getStartY(), paint);
            }
            //绘制阴影
            Paint paint = new Paint();
            path.lineTo(STOCK_VIEW_MARGIN * STOCK_VIEW_LEFT_RIGHT_MARGIN, timeY);
            path.lineTo(listLinePoint.get(listLinePoint.size() - 1).getStartX(), timeY);
            path.lineTo(listLinePoint.get(listLinePoint.size() - 1).getStartX(), listLinePoint.get(listLinePoint.size() - 1).getStartY());
            path.close();
            Shader mShasder;
            if (listLinePoint.get(0).getPaint().getColor() == StockMarketIndexViewModel.STOCK_MARKET_IDNEX_VIEW_RED_COLOR) {
                mShasder = new LinearGradient(listLinePoint.get(listLinePoint.size() - 1).getStartX(), listLinePoint.get(listLinePoint.size() - 1).getStartY(), listLinePoint.get(listLinePoint.size() - 1).getStartX(), timeY, new int[]{viewModel.getShadowColor(), viewModel.getShadowColor()}, null, Shader.TileMode.CLAMP);
            } else {
                mShasder = new LinearGradient(listLinePoint.get(listLinePoint.size() - 1).getStartX(), listLinePoint.get(listLinePoint.size() - 1).getStartY(), listLinePoint.get(listLinePoint.size() - 1).getStartX(), timeY, new int[]{viewModel.getShadowColor(), viewModel.getShadowColor()}, null, Shader.TileMode.CLAMP);
            }
            paint.setShader(mShasder);
            canvas.drawPath(path, paint);
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
