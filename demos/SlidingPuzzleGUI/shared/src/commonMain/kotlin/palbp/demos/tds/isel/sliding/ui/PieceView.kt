package palbp.demos.tds.isel.sliding.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PieceView(value: Int, onClick: () -> Unit) {
    val boxShape = ShapeDefaults.Large
    Box(
        contentAlignment = Center,
        modifier = Modifier
            .size(100.dp)
            .border(width = 2.dp, color = Color.Black, shape = boxShape)
            .clip(shape = boxShape)
            .clickable { onClick() }
    ) {
        Text(
            fontSize = 54.sp,
            text = value.toString(),
        )
    }
}

@Composable
@Preview
fun PieceViewPreview() {
    PieceView(value = 1, onClick = {})
}