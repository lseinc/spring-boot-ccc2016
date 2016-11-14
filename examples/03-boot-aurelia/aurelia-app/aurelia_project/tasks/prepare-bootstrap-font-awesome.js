import gulp from 'gulp';
import merge from 'merge-stream';
import changedInPlace from 'gulp-changed-in-place';
import project from '../aurelia.json';

export default function prepareBootstrapFontAwesome() {
  const sourceFA = 'node_modules/font-awesome';
  const sourceBS = 'node_modules/bootstrap/dist';

  const taskCss = gulp.src(`${sourceFA}/css/font-awesome.min.css`)
    .pipe(changedInPlace({ firstPass: true }))
    .pipe(gulp.dest(`${project.platform.output}/css`));

  const taskFonts = gulp.src(`${sourceFA}/fonts/*`)
    .pipe(changedInPlace({ firstPass: true }))
    .pipe(gulp.dest(`${project.platform.output}/fonts`));

  const taskCssBs = gulp.src(`${sourceBS}/css/bootstrap*.css`)
    .pipe(changedInPlace({ firstPass: true }))
    .pipe(gulp.dest(`${project.platform.output}/css`));

  const taskFontsBS = gulp.src(`${sourceBS}/fonts/*`)
    .pipe(changedInPlace({ firstPass: true }))
    .pipe(gulp.dest(`${project.platform.output}/fonts`));

  return merge(taskCss, taskFonts, taskCssBs, taskFontsBS);
}