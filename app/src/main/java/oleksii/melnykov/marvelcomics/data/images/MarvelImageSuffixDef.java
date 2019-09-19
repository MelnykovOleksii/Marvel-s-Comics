package oleksii.melnykov.marvelcomics.data.images;

import static java.lang.annotation.RetentionPolicy.SOURCE;
import static oleksii.melnykov.marvelcomics.data.images.MarvelImageSuffix.*;

import androidx.annotation.StringDef;
import java.lang.annotation.Retention;

@Retention(SOURCE)
@StringDef({
    // portrait
    PORTRAIT_SMALL, PORTRAIT_MEDIUM, PORTRAIT_XLARGE,
    PORTRAIT_FANTASTIC, PORTRAIT_UNCANNY, PORTRAIT_INCREDIBLE,
    // standard
    STANDARD_SMALL, STANDARD_MEDIUM, STANDARD_LARGE,
    STANDARD_XLARGE, STANDARD_FANTASTIC, STANDARD_AMAZING,
    // landscape
    LANDSCAPE_SMALL, LANDSCAPE_MEDIUM, LANDSCAPE_LARGE,
    LANDSCAPE_XLARGE, LANDSCAPE_AMAZING, LANDSCAPE_INCREDIBLE
})
public @interface MarvelImageSuffixDef {

}