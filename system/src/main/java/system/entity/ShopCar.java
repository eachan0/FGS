package system.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * shop_car
 * @author
 */
@Alias("shop_car")
public class ShopCar implements Serializable {
    private Integer userId;

    private Integer proId;

    private Double cjPrice;

    private Integer cjNum;

    private Double cjAmount;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Double getCjPrice() {
        return cjPrice;
    }

    public void setCjPrice(Double cjPrice) {
        this.cjPrice = cjPrice;
    }

    public Integer getCjNum() {
        return cjNum;
    }

    public void setCjNum(Integer cjNum) {
        this.cjNum = cjNum;
    }

    public Double getCjAmount() {
        return cjAmount;
    }

    public void setCjAmount(Double cjAmount) {
        this.cjAmount = cjAmount;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ShopCar other = (ShopCar) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getProId() == null ? other.getProId() == null : this.getProId().equals(other.getProId()))
            && (this.getCjPrice() == null ? other.getCjPrice() == null : this.getCjPrice().equals(other.getCjPrice()))
            && (this.getCjNum() == null ? other.getCjNum() == null : this.getCjNum().equals(other.getCjNum()))
            && (this.getCjAmount() == null ? other.getCjAmount() == null : this.getCjAmount().equals(other.getCjAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getProId() == null) ? 0 : getProId().hashCode());
        result = prime * result + ((getCjPrice() == null) ? 0 : getCjPrice().hashCode());
        result = prime * result + ((getCjNum() == null) ? 0 : getCjNum().hashCode());
        result = prime * result + ((getCjAmount() == null) ? 0 : getCjAmount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", proId=").append(proId);
        sb.append(", cjPrice=").append(cjPrice);
        sb.append(", cjNum=").append(cjNum);
        sb.append(", cjAmount=").append(cjAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
